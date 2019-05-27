(ns demo.core
  (:require [cljsjs.bootstrap]
            [cljsjs.jquery]
            [reagent.core :as r]
            [reitit.frontend :as rf]
            [reitit.frontend.easy :as rfe]
            [reitit.frontend.controllers :as rfc]
            [reitit.coercion :as rc]
            [reitit.coercion.schema :as rsc]
            [schema.core :as s]
            [bidi.bidi :as bidi]
            [bidi.router :as br]
            [fipp.edn :as fedn]
            [wise.router :as cr]))

(defn ysz []
  (println 1))

(defn zzz []
  [:div "1ghhjgjghjkli;23" [:div "asdassdgad"]
   [:a.nav-link {:href "#/" :onClick ysz} "asdasd"]
   ])

(defn zzzz []
  [:p "abuifnmfghjlohfvhmkc"
   [:a.nav-link {:href "#/a-items/item-112"} "asdasdsss"]
   ])

(defn xue [i]
  (fn []
    (if @i
      [:a.nav-link {:href "#/asdas"} "12312"]
      [:a.nav-link {:href "#/a-items/item-112"} "abc"])
    ))

(defn zzzzz [i]
  (fn []
    ;(let [ab (r/atom i)]
    (println @i)
    [:p "absd123123" @i [xue i]
     ]))

(def app-routes
  ["/" {""              zzzz
        "a-items"       {""                  :a-items
                         ["/item-" :item-id] zzzzz}
        "b-items"       {""                  :b-items
                         ["/item-" :item-id] :b-item}
        "about"         :about
        "missing-route" :missing-route
        true            zzz}])

(def app-routes-a
  ["/" {""              :index
        "a-items"       {""                  :a-items
                         ["/item-" :item-id] :a-item}
        "b-items"       {""                  :b-items
                         ["/item-" :item-id] :b-item}
        "about"         :about
        "missing-route" :missing-route
        true            :four-o-four}])

(defmulti page-contents identity)

(defmethod page-contents :index []
  (fn []
    [:span.main
     [:h1 "Welcome to routing-example"]
     [:ul
      [:li [:a {:href (bidi/path-for app-routes :a-items)} "Lots of items of type A"]]
      [:li [:a {:href (bidi/path-for app-routes :b-items)} "Many items of type B"]]
      [:li [:a {:href (bidi/path-for app-routes :missing-route)} "A Missing Route"]]
      [:li [:a {:href "/borken/link"} "A Borken Link"]]]
     [:p "Using "
      [:a {:href "https://reagent-project.github.io/"} "Reagent"] ", "
      [:a {:href "https://github.com/juxt/bidi"} "Bidi"] ", "
      [:a {:href "https://github.com/venantius/accountant"} "Accountant"] " & "
      [:a {:href "https://github.com/PEZ/clerk"} "Clerk"]
      ". Find this example on " [:a {:href "https://github.com/PEZ/reagent-bidi-accountant-example"} "Github"]]]))

(defn yyy [r]
  ;(fn []
  ;(let [abc (:handler @cr/!location)]
  ;(let [abc (cr/get-page)]
  [:div [cr/dispatch-router!]])

(defn ^:export xxx []
  (let [router (cr/start-router! app-routes)]
    (r/render [yyy router] (.getElementById js/document "app")))
  ;(cr/router! app-routes)
  ;(r/render [yyy] (.getElementById js/document "app"))
  )
