(ns cv.map)

(defn get-channel []
  (.connect js/OskariRPC element url))

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

(defn init-map [element url]
    (let [channel (get-channel element url)]
    (.onReady channel #(map-ready channel))))
