(ns cv.dropdown-test
  (:require [cljs.test :refer-macros [deftest testing is use-fixtures]]
            [cljs-react-test.utils :as tu]
            [cljs-react-test.simulate :as sim]
            [dommy.core :as dommy :refer-macros [sel1] :refer [text] ]
            [reagent.core :as r]
            [cv.app :refer [app]]
            [cv.state :refer [app-state
                              init-app-state]]
            [cv.dropdown :refer [dropdown]]
            [cv.mock-data :refer [mock-projects]]))

(def ^:dynamic c)

(use-fixtures :each (fn [test-fn]
                      (binding [c (tu/new-container!)]
                        (reset! app-state init-app-state)
                        (test-fn)
                        (tu/unmount! c))))


(deftest dropdown-has-label
  (testing "dropdown has a label")
    (let [_ (r/render-component [dropdown "foo" "bar" mock-projects] c)
          node (sel1 c [:#bar])]
      (is (not (nil? node)))))

