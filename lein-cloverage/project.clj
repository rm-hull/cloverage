(defproject rfkm/lein-cloverage "1.0.9-SNAPSHOT"
  :description "Lein plugin for cloverage"
  :url "https://github.com/rfkm/cloverage"
  :scm {:name "git"
        :dir  ".."
        :url  "https://github.com/rfkm/cloverage"
        :tag  "HEAD"}
  :vcs :git
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}
  :deploy-repositories [["snapshots" {:url "https://clojars.org/repo/"
                                      :username :env
                                      :password :env}]
                        ["releases" :clojars]]
  :min-lein-version "2.0.0"
  :dependencies [[bultitude "0.2.8"]]
  :plugins [[lein-file-replace "0.1.0"]]
  :eval-in-leiningen true
  :aliases {"sync-core-lib-version"
            ["file-replace"
             "src/leiningen/cloverage.clj"
             "cloverage-version \""
             "\""
             "version"]})
