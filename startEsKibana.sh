#!/usr/bin/env bash
export ES_HOME='/Users/starflutesg/Codebase/elasticsearch-7.0.1'
export KIBANA_HOME='/Users/starflutesg/Codebase/kibana-7.0.1-darwin-x86_64'

nohup sh $ES_HOME/bin/elasticsearch && nohup sh $KIBANA_HOME/bin/kibana