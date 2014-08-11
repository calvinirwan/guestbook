(defproject
  guestbook
  "0.1.0-SNAPSHOT"
  :repl-options
  {:init-ns guestbook.repl}
  :dependencies
  [[ring-server "0.3.1"]
   [noir-exception "0.2.2"]
   [postgresql/postgresql "9.1-901-1.jdbc4"]
   [ragtime "0.3.6"]
   [environ "0.5.0"]
   [com.taoensso/timbre "3.2.1"]
   [markdown-clj "0.9.47"]
   [im.chit/cronj "1.0.1"]
   [org.clojure/clojure "1.6.0"]
   [com.taoensso/tower "2.0.2"]
   [log4j
    "1.2.17"
    :exclusions
    [javax.mail/mail
     javax.jms/jms
     com.sun.jdmk/jmxtools
     com.sun.jmx/jmxri]]
   [korma "0.3.3"]
   [lib-noir "0.8.4"]
   [selmer "0.6.9"]]
  :ring
  {:handler guestbook.handler/app,
   :init guestbook.handler/init,
   :destroy guestbook.handler/destroy}
  :ragtime
  {:migrations ragtime.sql.files/migrations,
   :database
   "jdbc:postgresql://localhost/guestbook?user=db_user_name_here&password=db_user_password_here"}
  :profiles
  {:uberjar {:aot :all},
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}},
   :dev
   {:dependencies
    [[ring-mock "0.1.5"]
     [ring/ring-devel "1.3.0"]
     [pjstadig/humane-test-output "0.6.0"]],
    :injections
    [(require 'pjstadig.humane-test-output)
     (pjstadig.humane-test-output/activate!)],
    :env {:dev true}}}
  :url
  "http://example.com/FIXME"
  :jvm-opts
  ["-server"]
  :plugins
  [[lein-ring "0.8.10"]
   [lein-environ "0.5.0"]
   [ragtime/ragtime.lein "0.3.6"]]
  :description
  "FIXME: write description"
  :min-lein-version "2.0.0")