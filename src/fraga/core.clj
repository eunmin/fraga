(ns fraga.core
  (:require [clojure.spec.alpha :as s]))

;; type Character {
;;   name: String!
;;   appearsIn: [Episode]!
;; }

(s/def ::episode #{:newhope :empire :jedi})

(s/def ::appears-in (s/coll-of ::episode))

(s/def ::name string?)

(s/def ::character (s/keys :req-un [::name ::appears-in]))

;; type Starship {
;;   id: ID!
;;   name: String!
;;   length(unit: LengthUnit = METER): Float
;; }

(s/def ::id int?)

(s/def ::name string?)

(s/def ::length-unit #{:meter :centimeter})

(s/fdef length
  :args (s/cat :unit ::length-unit) ;; How to describe default value (= METER)?
  :ret float?)

(s/def ::startship (s/keys :req-un [::id ::name ::length]))

