"use strict";
/**
 * Created by Lenovo on 3/16/2017.
 */
var PagerObject = (function () {
    function PagerObject() {
        this.totalElements = 0;
        this.totalPages = 0;
        this.chooseRowsOnPage = [1, 2, 3];
    }
    return PagerObject;
}());
exports.PagerObject = PagerObject;
