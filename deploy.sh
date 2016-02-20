#!/bin/bash
(cd cloverage && lein deploy snapshots)
(cd lein-cloverage && lein deploy snapshots)
