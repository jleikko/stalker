(ns cv.state
  (:require [reagent.core :as r]))

(def init-app-state {})

(defonce app-state (r/atom init-app-state))
