(ns cloverage.debug
  (:require [clojure.java.io :as io]
            [clojure.pprint :as pp]))

(def ^:dynamic *debug* false)
;; debug output
(defn tprn [& args]
  (when *debug*
    (do
      (doall (map pp/pprint args))
      (newline))))

(defn tprnl [& args]
  (when *debug*
    (apply println args)))

(defn tprf [& args]
  (when *debug*
    (apply printf args)))

(defn dump-instrumented [forms name]
  (when *debug*
    (with-open [ou (io/writer (str "debug-" name))]
      (binding [*out* ou
                *print-meta* true]
        (doall (map prn forms))))))
