(ns clojurescript-koans.server
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [cljs.closure :as cljsc]
            [cljs.repl :as repl]
            [cljs.repl.browser :as browser]))

(def env (browser/repl-env :port 3001))

(cljsc/build ["src"]  {:output-dir "resources/public/js/out/" :output-to "resources/public/js/clojurescript_koans.js"})

(defroutes app-routes
  (GET "/" [] (io/resource "index.html"))
  (route/resources "/")
  (route/not-found "Not found"))

(def handler
  (-> (handler/api app-routes)))

