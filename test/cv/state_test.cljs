(ns cv.state-test
    (:require [cljs.test :refer-macros [deftest testing is use-fixtures]]
            [cv.state :refer [projects
                              consultants]]))


(deftest give-list-of-projects
  (testing "list of projects found")
    (is (vector? (projects)))

  (testing "more than 0 projects")
    (is (> (count (projects)) 0)))

(deftest give-list-of-consultants
  (testing "list of consultants found")
    (is (vector? (consultants)))

  (testing "more than 0 consultants")
    (is (> (count (consultants)) 0)))
