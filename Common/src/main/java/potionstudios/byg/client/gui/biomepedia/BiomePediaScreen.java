package potionstudios.byg.client.gui.biomepedia;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.client.gui.biomepedia.widgets.BookBackgroundWidget;
import potionstudios.byg.client.gui.biomepedia.widgets.BookTabButton;
import potionstudios.byg.client.gui.biomepedia.widgets.NestedWidget;
import potionstudios.byg.client.gui.biomepedia.widgets.pages.BPBiomeInfoPageWidget;
import potionstudios.byg.client.gui.biomepedia.widgets.pages.BPBiomePageWidget;
import potionstudios.byg.client.gui.biomepedia.widgets.pages.BPHomePageWidget;
import potionstudios.byg.client.gui.biomepedia.widgets.pages.BPSearchPageWidget;

public class BiomePediaScreen extends Screen {

	private NestedWidget activePanel;
	private BookPage<BPHomePageWidget> homePage;
	private BookPage<BPSearchPageWidget> searchPage;
	private BookPage<BPBiomePageWidget> biomeInfoPage, biomeBlocksPage, biomeMobsPage, biomeStructurePage;

	private BookTabButton searchButton;
	private BookTabButton[] tabs;

	private ResourceKey<Biome> selectedBiome;

	public BiomePediaScreen() {
		super(new TextComponent("BiomePedia"));
	}

	@Override
	protected void init() {
		super.init();

		int left = (this.width - 180)/2;
		int top = (this.height - 146)/2;

		tabs = new BookTabButton[]{
				new BookTabButton(left + 11, top + 20, 52, 242, true, (button) -> setTabTo(biomeInfoPage)),
				//new BookTabButton(left + 11, top + 39, 66, 242, true, (button) -> setTabTo(biomeBlocksPage)),
				//new BookTabButton(left + 11, top + 58, 80, 242, true, (button) -> setTabTo(biomeMobsPage)),
				//new BookTabButton(left + 11, top + 77, 94, 242, true, (button) -> setTabTo(biomeStructurePage)),
				searchButton = new BookTabButton(left + 11, top + 107, 108, 242, false, (button) -> setTabTo(searchPage))
		};

		homePage = new BookPage(new BPHomePageWidget((this.width - 180)/2, top), null);
		biomeInfoPage = new BookPage(new BPBiomeInfoPageWidget((this.width - 180)/2, top), tabs[0]);
		searchPage = new BookPage(new BPSearchPageWidget((this.width - 180)/2, top, this::selectBiome), searchButton);

		setTabTo(homePage);
	}

	public void selectBiome(ResourceKey<Biome> biomeInfo){
		this.selectedBiome = biomeInfo;
		if(this.selectedBiome != null)
			setTabTo(biomeInfoPage);
	}

	private void setTabTo(BookPage pageBook){
		for(int i = 0; i < tabs.length; i++)
			tabs[i].toggleVisibility(pageBook.isBiomeSpecific());

		if(pageBook.getTabButton() != null)
			pageBook.getTabButton().activate();

		searchButton.setPosY((this.height - 146)/2 + (pageBook.isBiomeSpecific() ? 107 : 20));

		if(pageBook.isBiomeSpecific) ((BPBiomePageWidget) pageBook.getTab()).setBiome(this.selectedBiome);

		setActivePanel(pageBook.getTab());
	}

	private void setActivePanel(NestedWidget panel){
		if(this.activePanel != null){
			this.removeWidget(this.activePanel);
		}
		this.activePanel = panel;
		this.addRenderableWidget(panel);

		//Necessary so the buttons stay in front of the book
		for(int i = 0; i < tabs.length; i++) {
			this.removeWidget(tabs[i]);
			this.addRenderableWidget(tabs[i]);
		}
	}

	class BookPage<T extends BookBackgroundWidget> {
		private T tab;
		private BookTabButton tabButton;
		private boolean isBiomeSpecific;

		public BookPage(T tab, BookTabButton tabButton) {
			this.tab = tab;
			this.tabButton = tabButton;
			this.isBiomeSpecific = tab instanceof BPBiomePageWidget;
		}

		public T getTab() {
			return tab;
		}

		public BookTabButton getTabButton() {
			return tabButton;
		}

		public boolean isBiomeSpecific() {
			return isBiomeSpecific;
		}
	}

}
