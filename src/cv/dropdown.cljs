(ns cv.dropdown)

(defn get-options [options]
  (vec (map (fn [option]
         [:option {:value (:id option)} (:name option)]) options)))

(defn dropdown [label id options]
  [:div
    [:div [:label.input-label {:id (str "label-" id)} label]]
    (vec (concat [:select {:id id}]  (get-options options)))])


