(ns cv.app
  (:require [cv.button :refer [button]]
            [cv.state :refer [counter
                              increase-count!
                              decrease-count!
                              projects
                              consultants]]
            [cv.dropdown :refer [dropdown]]
            [cv.input :refer [input]]))

(defn app []
  [:div
    [:h1#main-title "Add new allocation"]
    [:p (dropdown "Select a consultant" "consultants-dropdown" (consultants))]
    [:p (dropdown "Select a project" "projects-dropdown" (projects))]
    [:p (input "Allocation percentage"
               "allocation-percentage"
               "number")]
    [:p [:b (counter)]]
    [:p (button "Kasvata" "inc" increase-count!)]
    [:p (button "Vähennä" "dec" decrease-count!)]])
