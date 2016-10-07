(ns cv.simulator
  (:require [cv.button :refer [button]]
            [cv.ds :as ds]))


(defn simulator []
  [:div (button "start" "start-simulator" start-simulator)])


(defn start-simulator []
  (js/setTimeout send-location 250))

(defn send-location [lat lon]
  (send-location lat (+ lon 50)))


