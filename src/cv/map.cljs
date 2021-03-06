(ns cv.map
  (:require [cv.ds :refer [subscribe-locations]]))

(defn get-channel [element url]
  (.connect js/OskariRPC element url))

(defn add-marker [channel id x y color]
  (.postRequest channel "MapModulePlugin.AddMarkerRequest" (array (js-obj "x" x "y" y
    "size" 3 "color" color) id)))

;;(defn map-clicked [channel data]
;;  (.log js/console data)
;;  (add-marker channel "click" (.-lon data) (.-lat data) "ff0000"))

(defn map-ready [channel]
  (.log channel "Map ready")
  ;;(add-marker channel "ukkeli" 384717 6682960)
  (subscribe-locations "123" (partial handle-location-event channel)))
  ;;(.handleEvent channel "MapClickedEvent" (partial map-clicked channel)))


(defn handle-location-event [channel data]
  (add-marker channel "ukkeli" (:lon data) (:lat data) "ff0000"))


(defn init-map [element url]
    (let [channel (get-channel element url)]
    (.onReady channel #(map-ready channel))))
