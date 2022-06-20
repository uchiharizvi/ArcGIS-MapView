package com.example.app;

import com.esri.arcgisruntime.ArcGISRuntimeEnvironment;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.BasemapStyle;
import com.esri.arcgisruntime.mapping.Viewpoint;
import com.esri.arcgisruntime.mapping.view.MapView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    private MapView mapView;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // set the title and size of the stage and show it
        stage.setTitle("Display a map tutorial");
        stage.setWidth(800);
        stage.setHeight(700);
        stage.show();

        // create a JavaFX scene with a stack pane as the root node, and add it to the scene
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane);
        stage.setScene(scene);

        // create a map view to display the map and add it to the stack pane
        mapView = new MapView();
        stackPane.getChildren().add(mapView);

        //Add a map - topographic basemap style.
        ArcGISMap map = new ArcGISMap(BasemapStyle.ARCGIS_TOPOGRAPHIC);
        // set the map on the map view
        mapView.setMap(map);
        mapView.setViewpoint(new Viewpoint(12.962482784260573, 77.71560103439563, 144447.638572));

        String yourApiKey = "AAPK55e03a205b254f559799391a168eae9aJenadfWG0_OA7_ThrLG5oHfiba6S2clkj-as1qizRIF8Z2MEI1L25A_QAl5E_uKt";
        ArcGISRuntimeEnvironment.setApiKey(yourApiKey);
    }

    @Override
    public void stop() {
        if (mapView != null) mapView.dispose();
    }
}
