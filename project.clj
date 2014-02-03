(defproject clojurescript-koans "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :jvm-opts ^:replace ["-Xmx1g" "-server"]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2138"]
                 [prismatic/dommy "0.1.2"]]

  :plugins [[lein-ring "0.8.8"]
            [lein-cljsbuild "1.0.1"]]

  :source-paths ["src"]

  :ring {:handler clojurescript-koans.server/handler}

;;  :hooks  [leiningen.cljsbuild]

  :cljsbuild {
    :builds [{:id "clojurescript-koans"
              :source-paths ["src"]
              :compiler {
                :output-to "resources/public/js/runner.js"
                :output-dir "resources/public/js/runner"
                :optimizations :none
                :source-map true}}]})
