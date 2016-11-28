(ns gds-terminal-commands.core
  (:require [reagent.core :as reagent :refer [atom]]
            [ajax.core :as ajax]
            [gds-terminal-commands.components :as components]))

(enable-console-print!)

(defonce app-state (atom {:text "Hello world!" :name "Fuck" :info ""}))

(defn getInfo
  [handler]
  (ajax/GET "http://cdn.travel-swift.com/gds-terminal/db.json"
            {:handler handler
             :response-format :json
             :error-handler #(js/console.log "error" %)}))


(defn makeRequest
  [state]
  (getInfo #(swap! state :text %)))









(defn hello-world []
  [:h1 (:text @app-state)
   (components/mark (:info @app-state) (def on-click #(makeRequest app-state)))])

(reagent/render-component [hello-world]
                          (. js/document (getElementById "app")))

(defn on-js-reload [])
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
