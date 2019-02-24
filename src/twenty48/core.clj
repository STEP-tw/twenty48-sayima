(ns twenty48.core
  (:gen-class))

(def move-right 
  (comp
   (partial take-last 4)
   (partial concat (repeat 4 0))
   (partial map (partial apply +))
   (partial mapcat (partial partition-all 2))
   (partial partition-by identity)
   (partial filter (complement zero?))))

(def transpose (partial apply map list))

(def move-left (comp reverse move-right reverse))

(defn move-grid-right
  "Moves an entire grid to the right"
  [grid]
  (map move-right grid))

(def move-grid-left
  (partial map move-left))

(def move-grid-down
  "Moves an entire grid down"
  (comp
   transpose
   move-grid-right
   transpose))

(def move-grid-up
  "Moves an entire grid up"
  (comp
   transpose
   move-grid-left
   transpose))
