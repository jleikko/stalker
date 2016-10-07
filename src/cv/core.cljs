(ns cv.core
  (:require [reagent.core :as r]
            [cv.app :refer [app]]))

(defn get-channel []
  (.connect js/OskariRPC
    (.getElementById js/document "oskari-map")
    "http://www.paikkatietoikkuna.fi/published/fi/e8784853-1e4f-4644-9d00-5a3f2943f1e6"))

(defn add-marker [channel id x y color]
  (.postRequest channel "MapModulePlugin.AddMarkerRequest" (array (js-obj "x" x "y" y
    "size" 3 "color" color) id)))

(defn map-clicked [channel data]
  (.log js/console data)
  (add-marker channel "click" (.-lon data) (.-lat data) "ff0000"))

(defn map-ready [channel]
  (.log channel "Map ready")
  (add-marker channel "ukkeli" 384717 6682960)
  (.handleEvent channel "MapClickedEvent" (partial map-clicked channel)))

(defn init-oskari []
    (let [channel (get-channel)]
    (.onReady channel #(map-ready channel))))

(defn init []
  (r/render-component [app] (. js/document (getElementById "app")))
  (init-oskari))


(init)

