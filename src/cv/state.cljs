(ns cv.state
  (:require [reagent.core :as r]
              [cv.mock-data :refer [mock-projects
                                    mock-consultants]]))

(def init-app-state {:count 0
                     :projects mock-projects
                     :consultants mock-consultants})

(defonce app-state (r/atom init-app-state))

(defn counter []
  (:count @app-state))

(defn increase-count! []
  (swap! app-state update-in [:count] inc))


(defn decrease-count! []
  (swap! app-state update-in [:count] dec))

(defn projects []
  (:projects @app-state))

(defn consultants []
  (:consultants @app-state))
