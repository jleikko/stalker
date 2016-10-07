(ns cv.input-test
  (:require [cljs.test :refer-macros [deftest testing is use-fixtures]]
            [cljs-react-test.utils :as tu]
            [cljs-react-test.simulate :as sim]
            [dommy.core :as d :refer-macros [sel1] :refer [text
                                                           attr]]
            [reagent.core :as r]
            [cv.button :refer [button]]
            [cv.state :refer [app-state
                              init-app-state]]
            [cv.input :refer [input]]))

(def ^:dynamic c)

(use-fixtures :each (fn [test-fn]
                      (binding [c (tu/new-container!)]
                        (reset! app-state init-app-state)
                        (test-fn)
                        (tu/unmount! c))))

(deftest input-test
  (let [_ (r/render-component [input
                               "foo"
                               "bar"
                               "text"] c)
          input-field (sel1 c [:#bar])]
    (testing "testing input field exists"
      (is (not (nil? input-field))))
    (testing "testing text field default value exists"
      (is (= "text" (attr input-field :type))))))
