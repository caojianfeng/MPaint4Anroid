package org.zcoding.canvas;

/**
 * Created by caojianfeng on 16/3/20.
 */
public interface ILayerMan {
    void addLayer();
    void removeLayer();
    void mergLayers();
    boolean isLayerVisible();

}
