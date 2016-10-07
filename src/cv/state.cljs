(ns cv.state
  (:require [reagent.core :as r]))

(def init-app-state {:asdf 1})

(defonce app-state (r/atom init-app-state))
