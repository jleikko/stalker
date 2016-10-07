(ns cv.core
  (:require [reagent.core :as r]
            [cv.app :refer [app]]))

(r/render-component [app]
                          (. js/document (getElementById "app")))
