(ns cv.ds
  (:require [matchbox.core :as m]))

(def root (m/connect "https://stalker-dfcc3.firebaseio.com/"))

(defn ds-init []
  (m/auth-anon root))

(defn add-location [user-id timestamp lat lon]
  (m/conj!
    (m/get-in
      (m/get-in
        (m/get-in
          root
          "participants")
        user-id)
     "locations")
    {:logTime timestamp :lat lat :lon lon}))

(defn subscribe-locations [user-id func]
  "call func with newly added locations"
  (m/listen-to
    (m/get-in
      (m/get-in
        (m/get-in root
                  "participants")
        user-id)
     "locations") :child-added
    (fn [[k v]] (func v))))
