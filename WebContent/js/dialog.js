;
/**
 * 消息对话框插件
 * 
 * Date： 2018-9-24
 * author： chtao
 * 
 */
(function () {
    Object.defineProperty(window, 'dialog', {
        configurable: true,
        value: {}
    })

    function getByteLen(s) {
        var byte = s.length;
        for (let i = 0, len = s.length; i < len; ++i) {
            if (s.charCodeAt(i) > 127) {
                byte++;
            }
        }

        return byte;
    }

    Object.defineProperties(window.dialog, {
        show: {
            configurable: true,
            value: function () {
                var dialogDOC = document.querySelector('.dialog'),
                    xx = document.querySelector('.dialog .show-dialog .xx'),
                    showDialog = document.querySelector('.dialog .show-dialog'),
                    opacityBg = document.querySelector('.dialog .bg-opacity'),
                    self = this,
                    button = document.querySelector('.dialog .show-dialog .d-btn');

                // 显示界面
                dialogDOC.style.display = 'block';
                showDialog.style.animationName = 'fade-in-out';
                setTimeout(function () {
                    showDialog.style.animationName = '';
                }, 600);

                // 处理 按钮点击事件
                button.onclick = function (e) {
                    var target = e.target;

                    // 点击确定
                    if (target.className === 'confirm') {

                        self.dealConfirm();
                        dialogDOC.style.display = 'none';

                        // 点击取消
                    } else if (target.className === 'cancle') {

                        self.dealCancle();
                        dialogDOC.style.display = 'none';
                    }

                }

                // 缩放事件
                var firstTime = +new Date;
                opacityBg.onclick = function () {
                    // 对话框缩放效果
                    var secondTime = +new Date;

                    // 防抖功能
                    if (secondTime - firstTime > 600) {

                        showDialog.style.animationName = 'dialog-shake';
                        setTimeout(function () {
                            showDialog.style.animationName = '';
                        }, 500);
                        firstTime = secondTime;
                    }
                }

                // 'X'型取消按钮
                xx.addEventListener('click', function () {

                    dialogDOC.style.display = 'none';

                }, {
                    once: true
                });

            }
        },

        dealConfirm: {
            configurable: true,
            writable: true,
            value: function () {
                var dialogDOC = document.querySelector('.dialog');
                dialogDOC.style.display = 'none';
            }
        },

        dealCancle: {
            configurable: true,
            writable: true,
            value: function () {
                var dialogDOC = document.querySelector('.dialog');
                dialogDOC.style.display = 'none';
            }
        },

        setTitle: {
            configurable: true,
            value: function (s) {
                var byte = getByteLen(s);

                if (byte > 14) {
                    console.warn("标题太长");
                    return;
                }

                var title = document.querySelector('.dialog .show-dialog .title');
                title.innerText = s;
            }
        },

        setContent: {
            configurable: true,
            value: function (s) {
                var byte = getByteLen(s);

                if (byte > 100) {
                    console.warn('对话框内容过长');
                    return;
                }

                var content = document.querySelector('.dialog .show-dialog .content');
                content.innerText = s;
            }
        }

    })
}());