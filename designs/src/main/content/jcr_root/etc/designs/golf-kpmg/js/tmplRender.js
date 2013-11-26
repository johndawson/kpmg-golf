function VideoBlock(settings) {
    this.init(settings);
}
VideoBlock.prototype = {
    templateId : false,
    renderTarget : false,
    parsedData:{
        vBlockId : false,
        vLink: false
    },
    init : function(settings) {
        this.parsedData.vBlockId = settings.videoBlockId;
        this.parsedData.vLink = settings.videoLink;
        this.renderTarget = settings.renderTarget;
        this.templateId = settings.templateId;

        this.updateHTML();
    },
    updateHTML:function () {
        var renderTarget = jQuery('#' + this.renderTarget);
        //renderTarget.empty();
        if (this.parsedData) {
            jQuery('#' + this.templateId).tmpl(this.parsedData).appendTo(renderTarget);
        }
    }
};

function GalleryBlock(settings) {
    this.init(settings);
}
GalleryBlock.prototype = {
    templateId : false,
    renderTarget : false,
    parsedData:{
        pBlockId : false,
        images: false
    },
    init : function(settings) {
        this.parsedData.pBlockId = settings.videoBlockId;
        this.parsedData.images = settings.images;
        this.renderTarget = settings.renderTarget;
        this.templateId = settings.templateId;

        this.updateHTML();
    },
    updateHTML:function () {
        var renderTarget = jQuery('#' + this.renderTarget);
        //renderTarget.empty();
        if (this.parsedData) {
            jQuery('#' + this.templateId).tmpl(this.parsedData).appendTo(renderTarget);
        }
    }
};

function ReadBlock(settings) {
    this.init(settings);
}
ReadBlock.prototype = {
    templateId : false,
    renderTarget : false,
    parsedData:{
        rBlockId : false,
        rBlockImage: false,
        rContent: false
    },
    init : function(settings) {
        this.parsedData.rBlockId = settings.readBlockId;
        this.parsedData.rBlockImage = settings.readMoreImage;
        this.parsedData.rContent = settings.readContent;
        this.renderTarget = settings.renderTarget;
        this.templateId = settings.templateId;

        this.updateHTML();
    },
    updateHTML:function () {
        var renderTarget = jQuery('#' + this.renderTarget);
        //renderTarget.empty();
        if (this.parsedData) {
            jQuery('#' + this.templateId).tmpl(this.parsedData).appendTo(renderTarget);
        }
    }
};