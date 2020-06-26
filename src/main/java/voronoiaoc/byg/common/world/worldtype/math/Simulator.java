//package voronoiaoc.byg.common.world.worldtype.math;
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.image.PixelWriter;
//import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//
//import java.util.Random;
//
//public class Simulator extends Application {
//    public static void main(String[] args) {
//        launch();
//    }
//
//    @Override
//    public void start(Stage stage) throws Exception {
//        Pane pane = new Pane();
//        Canvas canvas = new Canvas(WIDTH, HEIGHT);
//        pane.getChildren().add(canvas);
//        stage.setScene(new Scene(pane));
//        stage.setWidth(WIDTH);
//        stage.setHeight(HEIGHT);
//
//        draw(canvas.getGraphicsContext2D().getPixelWriter(), WIDTH, HEIGHT);
//        stage.show();
//    }
//
//    private void draw(PixelWriter pwr, int width, int height) {
//        long seed = new Random().nextLong();
//        BiomeGroupManager manager = new BiomeGroupManager(seed);
//
//        for (int x = 0; x < WIDTH; ++x) {
//            int genX = (int) map(x, 0, WIDTH, -WIDTH / 2, WIDTH / 2);
//            genX = ((genX * BLOCKS_PER_PIXEL) >> SCALE_LAYERS_FOR_APPROXIMATION);
//
//            for (int z = 0; z < HEIGHT; ++z) {
//                int genZ = HEIGHT - z - 1;
//                genZ = (int) map(genZ, 0, HEIGHT, -HEIGHT / 2, HEIGHT / 2);
//                genZ = ((genZ * BLOCKS_PER_PIXEL) >> SCALE_LAYERS_FOR_APPROXIMATION);
//
//                switch (MODE) {
//                    case 0: // TEMPERATURE
//                        double temperature = manager.getTemperature(genX, genZ);
//                        temperature = clampMap(temperature, 1.0, -1.0, 0.0, 230);
//
//                        pwr.setColor(x, z, Color.hsb(temperature, 1.0, 1.0));
//                        break;
//                    case 1: // HUMIDITY
//                        double humidity = manager.getHumidity(genX, genZ);
//                        humidity = clampMap(humidity, -1.0, 1.0, 0.0, 255.0);
//
//                        pwr.setColor(x, z, Color.rgb(0, 0, (int) humidity));
//                        break;
//                    case 2: // CLIMATE
//                        double temp = manager.getTemperature(genX, genZ);
//                        temp = clampMap(temp, 1.0, -1.0, 0.0, 230);
//                        double humid = manager.getHumidity(genX, genZ);
//                        humid = clampMap(humid, -1.0, 1.0, 0.0, 1.0);
//
//                        pwr.setColor(x, z, Color.hsb(temp, 1.0, humid));
//                        break;
//                    case 3: // TEMPERATURE BANDS
//                        BiomeGroupManager.TempSection tempCategory = manager.getTempCategory(genX, genZ);
//                        switch (tempCategory) {
//                            case HOT:
//                                pwr.setColor(x, z, Color.WHITE);
//                                break;
//                            case TEMPERATE:
//                                pwr.setColor(x, z, Color.LIGHTSEAGREEN);
//                                break;
//                            case COOL:
//                                pwr.setColor(x, z, Color.GREEN);
//                                break;
//                            case COLD:
//                                pwr.setColor(x, z, Color.YELLOW);
//                                break;
//                        }
//                        break;
//                    case 4: // LAND/SEA
//                        ContinentSection section = manager.getSection(genX, genZ);
//                        Color colour = null;
//                        switch (section) {
//                            case COASTAL_CONTINENT:
//                                colour = Color.LIMEGREEN;
//                                break;
//                            case COASTAL_SEAS:
//                                colour = Color.CORNFLOWERBLUE;
//                                break;
//                            case INLAND_CONTINENT:
//                                colour = Color.GREEN;
//                                break;
//                            case THE_OCEAN:
//                                colour = Color.DARKBLUE;
//                                break;
//                        }
//
//                        pwr.setColor(x, z, colour);
//                        break;
//                }
//            }
//        }
//    }
//
//    private static double clampMap(double value, double oldmin, double oldmax, double newmin, double newmax) {
//        value -= oldmin;
//        value /= (oldmax - oldmin);
//        value = newmin + value * (newmax - newmin);
//        return value < newmin ? newmin : (value > newmax ? newmax : value);
//    }
//
//    private static double map(double value, double oldmin, double oldmax, double newmin, double newmax) {
//        value -= oldmin;
//        value /= (oldmax - oldmin);
//        value = newmin + value * (newmax - newmin);
//        return value;
//    }
//
//    private static final int MODE = 2;
//    static final int WIDTH = 1080, HEIGHT = 570;
//    @SuppressWarnings("unused")
//    static final int SCALE_LAYERS_FOR_APPROXIMATION = MODE < 4 ? BiomeGroupManager.CLIMATE_SCALE_LAYER_ADJUSTMENT : BiomeGroupManager.LAND_SEA_SCALE_LAYER_ADJUSTMENT;
//    static final int BLOCKS_PER_PIXEL = 35;
//}