(ns cv.input)

(defn input [label id input-type]
  [:div
   [:div [:label.input-label {:id (str "label-" id)} label]]
   [:input {:id id :type input-type}]])
