#!/bin/bash -e

cd cloverage

lein vcs assert-committed
lein change version leiningen.release/bump-version release

cd ../lein-cloverage

lein change version leiningen.release/bump-version release
lein vcs commit
lein vcs tag
lein deploy
lein change version leiningen.release/bump-version patch

cd ../cloverage

lein deploy
lein change version leiningen.release/bump-version patch
lein vcs commit
