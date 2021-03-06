(ns pjstadig.humane-test-output.records-test
  (:use [clojure.test]))

(defrecord ARecord [foo])
(defrecord BRecord [foo])

(deftest t-records
  (testing "these should not print as plain maps"
    (is (= (->ARecord :foo) (->ARecord :bar))))
  (testing "there should be a diff here"
    (is (= (->ARecord :foo) {:foo :foo})))
  (testing "and here"
    (is (= (->ARecord :foo) (->BRecord :foo)))))
