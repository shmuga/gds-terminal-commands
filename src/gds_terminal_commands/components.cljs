(ns gds-terminal-commands.components)


(defn mark [info on-button-click]
  [:p "Mark" " " info
   [:a {:onClick on-button-click} "click met"]])

(defn dan
  []
  [:p "Dan"])
