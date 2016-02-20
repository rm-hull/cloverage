(ns cloverage.test-report
  (:require [clojure.test :as t]
            [cloverage.report :as rep])
  (:import java.io.File))

(t/deftest test-relative-path
  (t/is (= "child/" (rep/relative-path (File. "parent/child/") (File. "parent/"))))
  (t/is (= "parent/child/"
           (rep/relative-path (File. "shared" "parent/child/") (File. "shared/"))))
  (t/is (= "parent/long dir name/"
           (rep/relative-path (File. "shared/parent/long dir name") (File. "shared"))))
  (t/is (= "../dir2/child/"
           (rep/relative-path (File. "dir2/child/") (File. "dir"))))
  (t/is (= "dir/" (rep/relative-path (File. "/tmp/dir/") (File. "/tmp"))))
  (t/is (= "" (rep/relative-path (File. "/") (File. "/"))))
  (t/is (= "" (rep/relative-path (File. "dir/file/") (File. "dir/file/")))))

(t/deftest total-stats-zero
  (t/is (= {:percent-lines-covered 0.0, :percent-forms-covered 0.0} (rep/total-stats {}))))
