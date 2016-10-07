(ns cv.core
  (:require [reagent.core :as r]
            [cv.app :refer [app]]
            [cv.map :refer [init-map
                            add-marker]]
            [cv.util :refer [by-id]]
            [cv.simulator :refer [simulator]]
            [cemerick.url :refer [url]]))

(defn init []
  (if (simulator?)
    (render simulator)
    (render app))
  (init-map
    (by-id "oskari-map")
    "http://www.paikkatietoikkuna.fi/published/fi/e8784853-1e4f-4644-9d00-5a3f2943f1e6"))

(defn simulator? []
  (get(-> (url (-> js/window .-location .-href))(:query)) "simulator"))

(defn render [element]
  (r/render-component [element] (by-id "app")))


(init)

