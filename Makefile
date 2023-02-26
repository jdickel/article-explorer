.PHONY: help
help:
	@echo "Displaying the help..."


##
# DEV
##
.PHONY: dev
dev:
	APP_ENV=dev


.env:
	cp -n .env.dist .env
