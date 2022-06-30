import { Datagrid, List, TextField, Create, SimpleForm, TextInput, Edit, EditButton } from "react-admin";



export const ProductList = (props) => (
    <List>
        <Datagrid rowClick="edit">
            <TextField source="id" />
            <TextField source="url_imagem" />
            <TextField source="title" />
            <TextField source="qualificacao" />
            <TextField source="descricao" />
            <TextField source="valor_diaria" />
            <EditButton basePath="/Administration" />
        </Datagrid>
    </List>
);


export const ProductCreate = (props) => (
    <Create>
        <SimpleForm>
            <TextInput source="id" disabled />
            <TextInput source="title" />
            <TextInput source="Category" />
            <TextInput source="qualificacao" />
            <TextInput source="descricao" />
            <TextInput source="valor_diaria" />

        </SimpleForm>
    </Create>
);

export const ProductEdit = (props) => (
    <Edit>
        <SimpleForm>
            <TextInput source="id" disabled />
            <TextInput source="url_imagem" />
            <TextInput source="title" />
            <TextInput source="qualificacao" />
            <TextInput source="descricao" />
            <TextInput source="valor_diaria" />
        </SimpleForm>
    </Edit>
);



