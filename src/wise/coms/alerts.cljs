(ns wise.coms.alerts
  (:require [reagent.core :refer [atom]]))

;;; 需要在document跟目录里先添加下面的alert-window

(def ^:private alert-id "wise-alert")

(def ^:private alert-content (atom {:content [:div] :display "none"}))

(defn close-alert! []
  (reset! alert-content {:display "none"}))

(defn alert-window []
  (let [{:keys [content display]} @alert-content]
    [:div {:id alert-id :style {:position "fixed" :z-index 1000 :top "50px" :right "50px" :width "400px" :display display}}
     content]))

(defn alert! "auto-close 不传默认为true 表示3秒后自动关闭，给false后不消失需要点击关闭才能关闭"
  ([content] (alert! content true))
  ([content auto-close]
   (reset! alert-content {:content content})
   (when auto-close
     (js/setTimeout close-alert! 3000))))

(defn alert-success
  ([content] (alert-success content true))
  ([msg auto-close]
   (alert! [:div.alert.alert-success
            [:button.close {:on-click close-alert!} "×"]
            [:strong "成功！"] msg] auto-close)))

(defn alert-warning
  ([content] (alert-warning content true))
  ([msg auto-close]
   (alert! [:div.alert.alert-warning
            [:button.close {:on-click close-alert!} "×"]
            [:strong "警告！"] msg] auto-close)))

(defn alert-danger
  ([content] (alert-danger content true))
  ([msg auto-close]
   (alert! [:div.alert.alert-danger
            [:button.close {:on-click close-alert!} "×"]
            [:strong "错误！"] msg] auto-close)))
