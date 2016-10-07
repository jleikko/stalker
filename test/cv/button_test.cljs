(ns cv.button-test
  (:require [cljs.test :refer-macros [deftest testing is use-fixtures]]
            [cljs-react-test.utils :as tu]
            [cljs-react-test.simulate :as sim]
            [dommy.core :as d :refer-macros [sel1] :refer [text]]
            [reagent.core :as r]
            [cv.button :refer [button]]
            [cv.state :refer [app-state
                              init-app-state]]))

(def ^:dynamic c)

(use-fixtures :each (fn [test-fn]
                      (binding [c (tu/new-container!)]
                        (reset! app-state init-app-state)
                        (test-fn)
                        (tu/unmount! c))))

(deftest renders-text-test
  (testing "renders text"
    (let [_ (r/render-component [button "foo" "bar" nil] c)
          node (sel1 c [:#bar])]
      (is (= "foo" (text node))))))

