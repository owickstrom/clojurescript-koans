(defproject clojurescript-koans "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2138"]
                 [prismatic/dommy "0.1.2"]]

  :plugins [[lein-cljsbuild "1.0.1"]]

  :source-paths ["src"]

  :hooks  [leiningen.cljsbuild]

  :cljsbuild {
    :builds [{:id "clojurescript-koans"
              :source-paths ["src"]
              :compiler {
                :output-to "clojurescript_koans.js"
                :output-dir "out"
                :optimizations :none
                :source-map true}}]})
