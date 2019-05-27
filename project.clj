(defproject wiseloong/coms "0.1.0-SNAPSHOT"
  :description "wiseloong-前端-组件"
  :url "www.wiseloong.com"
  :license {:name "wiseloong"}

  :dependencies [[reagent "0.8.1"]]

  :jar-exclusions [#"(?:^|\/)demo\/" #"html$"]

  :cljsbuild {:builds [{:id           "dev"
                        :source-paths ["src"]
                        :figwheel     true
                        :compiler     {:main       demo.core
                                       :asset-path "/cljs/out"
                                       :output-to  "target/cljsbuild/public/cljs/app.js"
                                       :preloads   [devtool.web]}}
                       {:id           "prod"
                        :source-paths ["src"]
                        :compiler     {:output-to     "resources/public/cljs/app.js"
                                       :output-dir    "target/cljsbuild/public/cljs/prod"
                                       :optimizations :advanced
                                       :pretty-print  false}}]}

  :profiles {:dev {:dependencies   [[org.clojure/clojure "1.9.0"]
                                    [org.clojure/clojurescript "1.10.439"]
                                    [wiseloong/router "0.1.0-SNAPSHOT"]
                                    [metosin/reitit-schema "0.2.8"]
                                    [metosin/reitit-frontend "0.2.8"]
                                    [cljsjs/bootstrap "3.3.6-1"]
                                    [cljsjs/react-bootstrap "0.31.5-0"]
                                    [re-com "2.2.0"]
                                    [bidi "2.1.5"]
                                    [fipp "0.6.12"]
                                    [wiseloong/devtool "1.1.0"]]
                   :plugins        [[lein-cljsbuild "1.1.7"]]
                   :resource-paths ["target/cljsbuild"]
                   :repl-options   {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}}})
