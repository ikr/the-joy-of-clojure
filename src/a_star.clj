(def world [[  1   1   1   1   1]
            [999 999 999 999   1]
            [  1   1   1   1   1]
            [  1 999 999 999 999]
            [  1   1   1   1   1]])

(defn neighbors
  ([m-size row-col] (neighbors [[-1 0] [0 1] [1 0] [0 -1]] m-size row-col))
  ([deltas m-size row-col]
     (filter
      (fn [row-col] (every? #(< -1 % m-size) row-col))
      (map #(map + row-col %) deltas))))

(defn estimate-cost [step-cost m-size row-col]
  (let [[x y] row-col]
    (* step-cost
       (- (* m-size 2) x y 2))))
