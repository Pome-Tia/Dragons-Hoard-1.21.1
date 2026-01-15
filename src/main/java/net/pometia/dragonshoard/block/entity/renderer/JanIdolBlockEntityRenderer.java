package net.pometia.dragonshoard.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.entity.ConduitBlockEntity;
import net.minecraft.world.phys.AABB;
import net.pometia.dragonshoard.block.entity.custom.idol.JanIdolBlockEntity;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class JanIdolBlockEntityRenderer implements BlockEntityRenderer<JanIdolBlockEntity> {


    public static final Material SHELL_TEXTURE;
    public static final Material ACTIVE_SHELL_TEXTURE;
    public static final Material WIND_TEXTURE;
    public static final Material VERTICAL_WIND_TEXTURE;
    public static final Material OPEN_EYE_TEXTURE;
    public static final Material CLOSED_EYE_TEXTURE;
    private final ModelPart eye;
    private final ModelPart wind;
    private final ModelPart shell;
    private final ModelPart cage;
    private final BlockEntityRenderDispatcher renderer;
    public JanIdolBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.renderer = context.getBlockEntityRenderDispatcher();
        this.eye = context.bakeLayer(ModelLayers.CONDUIT_EYE);
        this.wind = context.bakeLayer(ModelLayers.CONDUIT_WIND);
        this.shell = context.bakeLayer(ModelLayers.CONDUIT_SHELL);
        this.cage = context.bakeLayer(ModelLayers.CONDUIT_CAGE);
    }

    public static LayerDefinition createEyeLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    public static LayerDefinition createWindLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("wind", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    public static LayerDefinition createShellLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 32, 16);
    }

    public static LayerDefinition createCageLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 32, 16);
    }

    public void render(ConduitBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        float f = (float)blockEntity.tickCount + partialTick;
        float f5;
        if (!blockEntity.isActive()) {
            f5 = blockEntity.getActiveRotation(0.0F);
            VertexConsumer vertexconsumer1 = SHELL_TEXTURE.buffer(bufferSource, RenderType::entitySolid);
            poseStack.pushPose();
            poseStack.translate(0.5F, 0.5F, 0.5F);
            poseStack.mulPose((new Quaternionf()).rotationY(f5 * 0.017453292F));
            this.shell.render(poseStack, vertexconsumer1, packedLight, packedOverlay);
            poseStack.popPose();
        } else {
            f5 = blockEntity.getActiveRotation(partialTick) * 57.295776F;
            float f2 = Mth.sin(f * 0.1F) / 2.0F + 0.5F;
            f2 += f2 * f2;
            poseStack.pushPose();
            poseStack.translate(0.5F, 0.3F + f2 * 0.2F, 0.5F);
            Vector3f vector3f = (new Vector3f(0.5F, 1.0F, 0.5F)).normalize();
            poseStack.mulPose((new Quaternionf()).rotationAxis(f5 * 0.017453292F, vector3f));
            this.cage.render(poseStack, ACTIVE_SHELL_TEXTURE.buffer(bufferSource, RenderType::entityCutoutNoCull), packedLight, packedOverlay);
            poseStack.popPose();
            int i = blockEntity.tickCount / 66 % 3;
            poseStack.pushPose();
            poseStack.translate(0.5F, 0.5F, 0.5F);
            if (i == 1) {
                poseStack.mulPose((new Quaternionf()).rotationX(1.5707964F));
            } else if (i == 2) {
                poseStack.mulPose((new Quaternionf()).rotationZ(1.5707964F));
            }

            VertexConsumer vertexconsumer = (i == 1 ? VERTICAL_WIND_TEXTURE : WIND_TEXTURE).buffer(bufferSource, RenderType::entityCutoutNoCull);
            this.wind.render(poseStack, vertexconsumer, packedLight, packedOverlay);
            poseStack.popPose();
            poseStack.pushPose();
            poseStack.translate(0.5F, 0.5F, 0.5F);
            poseStack.scale(0.875F, 0.875F, 0.875F);
            poseStack.mulPose((new Quaternionf()).rotationXYZ(3.1415927F, 0.0F, 3.1415927F));
            this.wind.render(poseStack, vertexconsumer, packedLight, packedOverlay);
            poseStack.popPose();
            Camera camera = this.renderer.camera;
            poseStack.pushPose();
            poseStack.translate(0.5F, 0.3F + f2 * 0.2F, 0.5F);
            poseStack.scale(0.5F, 0.5F, 0.5F);
            float f3 = -camera.getYRot();
            poseStack.mulPose((new Quaternionf()).rotationYXZ(f3 * 0.017453292F, camera.getXRot() * 0.017453292F, 3.1415927F));
            float f4 = 1.3333334F;
            poseStack.scale(1.3333334F, 1.3333334F, 1.3333334F);
            this.eye.render(poseStack, (blockEntity.isHunting() ? OPEN_EYE_TEXTURE : CLOSED_EYE_TEXTURE).buffer(bufferSource, RenderType::entityCutoutNoCull), packedLight, packedOverlay);
            poseStack.popPose();
        }

    }

    public AABB getRenderBoundingBox(ConduitBlockEntity blockEntity) {
        BlockPos pos = blockEntity.getBlockPos();
        return new AABB((double)pos.getX(), (double)pos.getY() - 0.25, (double)pos.getZ(), (double)pos.getX() + 1.0, (double)pos.getY() + 1.25, (double)pos.getZ() + 1.0);
    }

    static {
        SHELL_TEXTURE = new Material(TextureAtlas.LOCATION_BLOCKS, ResourceLocation.withDefaultNamespace("entity/conduit/base"));
        ACTIVE_SHELL_TEXTURE = new Material(TextureAtlas.LOCATION_BLOCKS, ResourceLocation.withDefaultNamespace("entity/conduit/cage"));
        WIND_TEXTURE = new Material(TextureAtlas.LOCATION_BLOCKS, ResourceLocation.withDefaultNamespace("entity/conduit/wind"));
        VERTICAL_WIND_TEXTURE = new Material(TextureAtlas.LOCATION_BLOCKS, ResourceLocation.withDefaultNamespace("entity/conduit/wind_vertical"));
        OPEN_EYE_TEXTURE = new Material(TextureAtlas.LOCATION_BLOCKS, ResourceLocation.withDefaultNamespace("entity/conduit/open_eye"));
        CLOSED_EYE_TEXTURE = new Material(TextureAtlas.LOCATION_BLOCKS, ResourceLocation.withDefaultNamespace("entity/conduit/closed_eye"));
    }

    @Override
    public void render(JanIdolBlockEntity janIdolBlockEntity, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {

    }
}
