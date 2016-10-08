(ns cv.simulator
  (:require [cv.button :refer [button]]
            [cv.ds :as ds]))


(defn simulator []
  [:div
   (button "start" "start-simulator" start-simulator)
   (button "clear" "clear-locations" clear)])


(defn start-simulator []
  (send-location 6682804 383998 true))

(defn send-location [lat lon toRight]
  (ds/add-location "123" (.getTime (js/Date.)) lat lon)
  (js/setTimeout #(send-location lat (move lon toRight) (resolveDirection lat lon toRight)) 100))

(defn move [lon toRight]
  (if toRight
    (+ lon 5)
    (- lon 5)))

(defn resolveDirection [lat lon toRight]
  (cond
    (and (> lon 384842) toRight) false
    (and (< lon 383998) (not toRight)) true
    :else toRight))

(defn clear []
  (ds/clear-locations "123"))

