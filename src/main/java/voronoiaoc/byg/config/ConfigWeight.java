package voronoiaoc.byg.config;


import tk.valoeghese.zoesteriaconfig.api.deserialiser.Comment;
import tk.valoeghese.zoesteriaconfig.api.template.ConfigTemplate;

public class ConfigWeight {
    private final String name;
    private final int defaultWeight;

    private int configWeight;

    public ConfigWeight(String name, int defaultWeight) {
        this.name = name;
        this.defaultWeight = defaultWeight;
        ConfigWeightManager.biomeWeights.add(this);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return configWeight;
    }

    public void setWeight(int configValue) {
        configWeight = configValue;
    }

    public ConfigTemplate apply() {
        return ConfigTemplate.builder().addContainer(name, c -> c.addComment(new Comment("Set to 0 to disable generation. Default Weight is: " + defaultWeight)).addDataEntry("Weight", defaultWeight)).build();
    }
}
