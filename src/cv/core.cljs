(ns cv.core
  (:require [reagent.core :as r]
            [cv.app :refer [app]]))

(r/render-component [app]
                          (. js/document (getElementById "app")))

(def channelGlobal (.connect js/OskariRPC
    (.getElementById js/document "oskari-map") 
    "http://www.paikkatietoikkuna.fi/published/fi/e8784853-1e4f-4644-9d00-5a3f2943f1e6"))

(.log channelGlobal "Channel present")
;;(.log channelGlobal (.-VERSION js/OskariRPC))


(.onReady channelGlobal #(mapReady channelGlobal))

(defn mapReady [channel]
  (.log channel "Map ready")
  (addMarker "ukkeli" 384717 6682960)
  (.handleEvent channel "MapClickedEvent" mapClicked)
)

(defn mapClicked [data]
  (.log channelGlobal data)
  (addMarker "click" (.-lon data) (.-lat data) "ff0000")
)

;; to get current position in browser console run:
;; window.cv.core.channelGlobal.getMapPosition(console.log)
(defn addMarker [id x y color]
  (.postRequest channelGlobal "MapModulePlugin.AddMarkerRequest" (array (js-obj "x" x "y" y 
    "size" 3 "color" color) id))
)
