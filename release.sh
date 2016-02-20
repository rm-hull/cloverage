#!/bin/bash -e

cd lein-cloverage

lein vcs assert-committed
lein change version leiningen.release/bump-version release
lein sync-core-lib-version

cd ../cloverage

lein change version leiningen.release/bump-version release
lein vcs commit
lein vcs tag
lein deploy
lein change version leiningen.release/bump-version patch

cd ../lein-cloverage

lein deploy
lein change version leiningen.release/bump-version patch
lein sync-core-lib-version
lein vcs commit
