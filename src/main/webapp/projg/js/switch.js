/* ========================================================================
 * bootstrap-switch - v3.0.0
 * http://www.bootstrap-switch.org
 * ========================================================================
 * Copyright 2012-2013 Mattia Larentis
 *
 * ========================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================================
 */

(function() {
  var __slice = [].slice;

  (function($, window) {
    "use strict";
    var BootstrapSwitch;
    BootstrapSwitch = (function() {
      BootstrapSwitch.prototype.name = "bootstrap-switch";

      function BootstrapSwitch(element, options) {
        var addClasses;
        if (options == null) {
          options = {};
        }
        this.$element = $(element);
        this.options = $.extend({}, $.fn.bootstrapSwitch.defaults, options, {
          state: this.$element.is(":checked"),
          size: this.$element.data("size"),
          animate: this.$element.data("animate"),
          disabled: this.$element.is(":disabled"),
          readonly: this.$element.is("[readonly]"),
          onColor: this.$element.data("on-color"),
          offColor: this.$element.data("off-color"),
          onText: this.$element.data("on-text"),
          offText: this.$element.data("off-text"),
          labelText: this.$element.data("label-text")
        });
        this.$wrapper = $("<div>");
        this.$container = $("<div>");
        this.$on = $("<span>", {
          html: this.options.onText
        });
        this.$off = $("<span>", {
          html: this.options.offText
        });
        this.$label = $("<label>", {
          "for": this.$element.attr("id"),
          html: this.options.labelText
        });
        addClasses = (function(_this) {
          return function(cls) {
            var c, classes, _i, _len;
            if (!$.isArray(cls)) {
              return "" + _this.options.baseClass + "-" + cls;
            }
            classes = [];
            for (_i = 0, _len = cls.length; _i < _len; _i++) {
              c = cls[_i];
              classes.push("" + _this.options.baseClass + "-" + c);
            }
            return classes.join(" ");
          };
        })(this);
        this.$wrapper.addClass((function(_this) {
          return function() {
            var classes;
            classes = ["" + _this.options.baseClass, "" + _this.options.baseClass + "-" + _this.options.wrapperClass];
            classes.push(_this.options.state ? "" + _this.options.baseClass + "-" + _this.options.onModifierClass : "" + _this.options.baseClass + "-" + _this.options.offModifierClass);
            if (_this.options.size != null) {
              classes.push("" + _this.options.baseClass + "-" + _this.options.size);
            }
            if (_this.options.animate) {
              classes.push("" + _this.options.baseClass + "-" + _this.options.animateModifierClass);
            }
            if (_this.options.disabled) {
              classes.push("" + _this.options.baseClass + "-" + _this.options.disabledModifierClass);
            }
            if (_this.options.readonly) {
              classes.push("" + _this.options.baseClass + "-" + _this.options.readonlyModifierClass);
            }
            if (_this.$element.attr("id")) {
              classes.push("" + _this.options.baseClass + "-id-" + (_this.$element.attr("id")));
            }
            return classes.join(" ");
          };
        })(this));
        this.$container.addClass(addClasses(this.options.containerClass));
        this.$on.addClass("" + (addClasses(this.options.handleOnClass)) + " " + this.options.baseClass + "-" + this.options.onColor);
        this.$off.addClass("" + (addClasses(this.options.handleOffClass)) + " " + this.options.baseClass + "-" + this.options.offColor);
        this.$label.addClass(addClasses(this.options.labelClass));
        this.$element.on("init.bootstrapSwitch", (function(_this) {
          return function() {
            return _this.options.onInit.apply(element, arguments);
          };
        })(this));
        this.$element.on("switchChange.bootstrapSwitch", (function(_this) {
          return function() {
            return _this.options.onSwitchChange.apply(element, arguments);
          };
        })(this));
        this.$container = this.$element.wrap(this.$container).parent();
        this.$wrapper = this.$container.wrap(this.$wrapper).parent();
        this.$element.before(this.$on).before(this.$label).before(this.$off).trigger("init.bootstrapSwitch");
        this._elementHandlers();
        this._handleHandlers();
        this._labelHandlers();
        this._formHandler();
      }

      BootstrapSwitch.prototype._constructor = BootstrapSwitch;

      BootstrapSwitch.prototype.state = function(value, skip) {
        if (typeof value === "undefined") {
          return this.options.state;
        }
        if (this.options.disabled || this.options.readonly) {
          return this.$element;
        }
        value = !!value;
        this.$element.prop("checked", value).trigger("change.bootstrapSwitch", skip);
        return this.$element;
      };

      BootstrapSwitch.prototype.toggleState = function(skip) {
        if (this.options.disabled || this.options.readonly) {
          return this.$element;
        }
        return this.$element.prop("checked", !this.options.state).trigger("change.bootstrapSwitch", skip);
      };

      BootstrapSwitch.prototype.size = function(value) {
        if (typeof value === "undefined") {
          return this.options.size;
        }
        if (this.options.size != null) {
          this.$wrapper.removeClass("" + this.options.baseClass + "-" + this.options.size);
        }
        this.$wrapper.addClass("" + this.options.baseClass + "-" + value);
        this.options.size = value;
        return this.$element;
      };

      BootstrapSwitch.prototype.animate = function(value) {
        if (typeof value === "undefined") {
          return this.options.animate;
        }
        value = !!value;
        this.$wrapper[value ? "addClass" : "removeClass"]("" + this.options.baseClass + "-" + this.options.animateModifierClass);
        this.options.animate = value;
        return this.$element;
      };

      BootstrapSwitch.prototype.disabled = function(value) {
        if (typeof value === "undefined") {
          return this.options.disabled;
        }
        value = !!value;
        this.$wrapper[value ? "addClass" : "removeClass"]("" + this.options.baseClass + "-" + this.options.disabledModifierClass);
        this.$element.prop("disabled", value);
        this.options.disabled = value;
        return this.$element;
      };

      BootstrapSwitch.prototype.toggleDisabled = function() {
        this.$element.prop("disabled", !this.options.disabled);
        this.$wrapper.toggleClass("" + this.options.baseClass + "-" + this.options.disabledModifierClass);
        this.options.disabled = !this.options.disabled;
        return this.$element;
      };

      BootstrapSwitch.prototype.readonly = function(value) {
        if (typeof value === "undefined") {
          return this.options.readonly;
        }
        value = !!value;
        this.$wrapper[value ? "addClass" : "removeClass"]("" + this.options.baseClass + "-" + this.options.readonlyModifierClass);
        this.$element.prop("readonly", value);
        this.options.readonly = value;
        return this.$element;
      };

      BootstrapSwitch.prototype.toggleReadonly = function() {
        this.$element.prop("readonly", !this.options.readonly);
        this.$wrapper.toggleClass("" + this.options.baseClass + "-" + this.options.readonlyModifierClass);
        this.options.readonly = !this.options.readonly;
        return this.$element;
      };

      BootstrapSwitch.prototype.onColor = function(value) {
        var color;
        color = this.options.onColor;
        if (typeof value === "undefined") {
          return color;
        }
        if (color != null) {
          this.$on.removeClass("" + this.options.baseClass + "-" + color);
        }
        this.$on.addClass("" + this.options.baseClass + "-" + value);
        this.options.onColor = value;
        return this.$element;
      };

      BootstrapSwitch.prototype.offColor = function(value) {
        var color;
        color = this.options.offColor;
        if (typeof value === "undefined") {
          return color;
        }
        if (color != null) {
          this.$off.removeClass("" + this.options.baseClass + "-" + color);
        }
        this.$off.addClass("" + this.options.baseClass + "-" + value);
        this.options.offColor = value;
        return this.$element;
      };

      BootstrapSwitch.prototype.onText = function(value) {
        if (typeof value === "undefined") {
          return this.options.onText;
        }
        this.$on.html(value);
        this.options.onText = value;
        return this.$element;
      };

      BootstrapSwitch.prototype.offText = function(value) {
        if (typeof value === "undefined") {
          return this.options.offText;
        }
        this.$off.html(value);
        this.options.offText = value;
        return this.$element;
      };

      BootstrapSwitch.prototype.labelText = function(value) {
        if (typeof value === "undefined") {
          return this.options.labelText;
        }
        this.$label.html(value);
        this.options.labelText = value;
        return this.$element;
      };

      BootstrapSwitch.prototype.destroy = function() {
        var $form;
        $form = this.$element.closest("form");
        if ($form.length) {
          $form.off("reset.bootstrapSwitch").removeData("bootstrap-switch");
        }
        this.$container.children().not(this.$element).remove();
        this.$element.unwrap().unwrap().off(".bootstrapSwitch").removeData("bootstrap-switch");
        return this.$element;
      };

      BootstrapSwitch.prototype._elementHandlers = function() {
        return this.$element.on({
          "change.bootstrapSwitch": (function(_this) {
            return function(e, skip) {
              var checked;
              e.preventDefault();
              e.stopPropagation();
              e.stopImmediatePropagation();
              checked = _this.$element.is(":checked");
              if (checked === _this.options.state) {
                return;
              }
              _this.options.state = checked;
              _this.$wrapper.removeClass(checked ? "" + _this.options.baseClass + "-" + _this.options.offModifierClass : "" + _this.options.baseClass + "-" + _this.options.onModifierClass).addClass(checked ? "" + _this.options.baseClass + "-" + _this.options.onModifierClass : "" + _this.options.baseClass + "-" + _this.options.offModifierClass);
              if (!skip) {
                if (_this.$element.is(":radio")) {
                  $("[name='" + (_this.$element.attr('name')) + "']").not(_this.$element).prop("checked", false).trigger("change.bootstrapSwitch", true);
                }
                return _this.$element.trigger("switchChange.bootstrapSwitch", [checked]);
              }
            };
          })(this),
          "focus.bootstrapSwitch": (function(_this) {
            return function(e) {
              e.preventDefault();
              e.stopPropagation();
              e.stopImmediatePropagation();
              return _this.$wrapper.addClass("" + _this.options.baseClass + "-" + _this.options.focusedModifierClass);
            };
          })(this),
          "blur.bootstrapSwitch": (function(_this) {
            return function(e) {
              e.preventDefault();
              e.stopPropagation();
              e.stopImmediatePropagation();
              return _this.$wrapper.removeClass("" + _this.options.baseClass + "-" + _this.options.focusedModifierClass);
            };
          })(this),
          "keydown.bootstrapSwitch": (function(_this) {
            return function(e) {
              if (!e.which || _this.options.disabled || _this.options.readonly) {
                return;
              }
              switch (e.which) {
                case 32:
                  e.preventDefault();
                  e.stopPropagation();
                  e.stopImmediatePropagation();
                  return _this.toggleState();
                case 37:
                  e.preventDefault();
                  e.stopPropagation();
                  e.stopImmediatePropagation();
                  return _this.state(false);
                case 39:
                  e.preventDefault();
                  e.stopPropagation();
                  e.stopImmediatePropagation();
                  return _this.state(true);
              }
            };
          })(this)
        });
      };

      BootstrapSwitch.prototype._handleHandlers = function() {
        this.$on.on("click.bootstrapSwitch", (function(_this) {
          return function(e) {
            _this.state(false);
            return _this.$element.trigger("focus.bootstrapSwitch");
          };
        })(this));
        return this.$off.on("click.bootstrapSwitch", (function(_this) {
          return function(e) {
            _this.state(true);
            return _this.$element.trigger("focus.bootstrapSwitch");
          };
        })(this));
      };

      BootstrapSwitch.prototype._labelHandlers = function() {
        return this.$label.on({
          "mousemove.bootstrapSwitch touchmove.bootstrapSwitch": (function(_this) {
            return function(e) {
              var left, percent, right;
              if (!_this.drag) {
                return;
              }
              e.preventDefault();
              percent = (((e.pageX || e.originalEvent.touches[0].pageX) - _this.$wrapper.offset().left) / _this.$wrapper.width()) * 100;
              left = 25;
              right = 75;
              if (percent < left) {
                percent = left;
              } else if (percent > right) {
                percent = right;
              }
              _this.$container.css("margin-left", "" + (percent - right) + "%");
              return _this.$element.trigger("focus.bootstrapSwitch");
            };
          })(this),
          "mousedown.bootstrapSwitch touchstart.bootstrapSwitch": (function(_this) {
            return function(e) {
              if (_this.drag || _this.options.disabled || _this.options.readonly) {
                return;
              }
              e.preventDefault();
              _this.drag = true;
              if (_this.options.animate) {
                _this.$wrapper.removeClass("" + _this.options.baseClass + "-" + _this.options.animateModifierClass);
              }
              return _this.$element.trigger("focus.bootstrapSwitch");
            };
          })(this),
          "mouseup.bootstrapSwitch touchend.bootstrapSwitch": (function(_this) {
            return function(e) {
              if (!_this.drag) {
                return;
              }
              e.preventDefault();
              _this.drag = false;
              _this.$element.prop("checked", parseInt(_this.$container.css("margin-left"), 10) > -(_this.$container.width() / 6)).trigger("change.bootstrapSwitch");
              _this.$container.css("margin-left", "");
              if (_this.options.animate) {
                return _this.$wrapper.addClass("" + _this.options.baseClass + "-" + _this.options.animateModifierClass);
              }
            };
          })(this),
          "mouseleave.bootstrapSwitch": (function(_this) {
            return function(e) {
              return _this.$label.trigger("mouseup.bootstrapSwitch");
            };
          })(this)
        });
      };

      BootstrapSwitch.prototype._formHandler = function() {
        var $form;
        $form = this.$element.closest("form");
        if ($form.data("bootstrap-switch")) {
          return;
        }
        return $form.on("reset.bootstrapSwitch", function() {
          return window.setTimeout(function() {
            return $form.find("input").filter(function() {
              return $(this).data("bootstrap-switch");
            }).each(function() {
              return $(this).bootstrapSwitch("state", false);
            });
          }, 1);
        }).data("bootstrap-switch", true);
      };

      return BootstrapSwitch;

    })();
    $.fn.bootstrapSwitch = function() {
      var args, option, ret;
      option = arguments[0], args = 2 <= arguments.length ? __slice.call(arguments, 1) : [];
      ret = this;
      this.each(function() {
        var $this, data;
        $this = $(this);
        data = $this.data("bootstrap-switch");
        if (!data) {
          $this.data("bootstrap-switch", data = new BootstrapSwitch(this, option));
        }
        if (typeof option === "string") {
          return ret = data[option].apply(data, args);
        }
      });
      return ret;
    };
    $.fn.bootstrapSwitch.Constructor = BootstrapSwitch;
    return $.fn.bootstrapSwitch.defaults = {
      state: true,
      size: null,
      animate: true,
      disabled: false,
      readonly: false,
      onColor: "primary",
      offColor: "default",
      onText: "ON",
      offText: "OFF",
      labelText: "&nbsp;",
      baseClass: "bootstrap-switch",
      wrapperClass: "wrapper",
      containerClass: "container",
      handleOnClass: "handle-on",
      handleOffClass: "handle-off",
      labelClass: "label",
      onModifierClass: "on",
      offModifierClass: "off",
      focusedModifierClass: "focused",
      animateModifierClass: "animate",
      disabledModifierClass: "disabled",
      readonlyModifierClass: "readonly",
      onInit: function() {},
      onSwitchChange: function() {}
    };
  })(window.jQuery, window);

}).call(this);
