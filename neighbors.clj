(def matrix
  [[1 2 3]
   [4 5 6]
   [7 8 9]])

(defn neighbors
  ([msize row-col] (neighbors [[-1 0] [0 1] [1 0] [0 -1]] msize row-col))
  ([deltas msize row-col]
     (map #(map + row-col %) deltas)))


(neighbors 3 [1 1])
