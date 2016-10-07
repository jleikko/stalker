(ns cv.core
  (:require [reagent.core :as r]
            [cv.app :refer [app]]
            [cv.map :refer [init-map]]
            [cv.util :refer [get-id]]))

(defn init []
  (r/render-component [app] (get-id "app"))
  (init-map
    (get-id "oskari-map")
    "http://www.paikkatietoikkuna.fi/published/fi/e8784853-1e4f-4644-9d00-5a3f2943f1e6"))


(init)

