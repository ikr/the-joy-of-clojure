(def matrix
  [[1 2 3]
   [4 5 6]
   [7 8 9]])

(defn neighbors
  ([msize row-col] (neighbors [[-1 0] [0 1] [1 0] [0 -1]] msize row-col))
  ([deltas msize row-col]
     (filter
      (fn [row-col] (every? #(< -1 % msize) row-col))
      (map #(map + row-col %) deltas))))


(neighbors 3 [0 0])

(get-in matrix [2 1])

(map #(get-in matrix %) (neighbors 3 [0 0]))
