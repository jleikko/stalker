(ns cv.simulator
  (:require [cv.button :refer [button]]
            [cv.ds :as ds]))


(defn simulator []
  [:div
   (button "start" "start-simulator" start-simulator)
   (button "clear" "clear-locations" clear-locations)])


(defn start-simulator []
  (send-location 6682804 383998))

(defn send-location [lat lon]
  (ds/add-location "123" (.getTime (js/Date.)) lat lon)
  (js/setTimeout (send-location lat (+ lon 50)) 500))


